import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Status } from './status.model';
import { StatusPopupService } from './status-popup.service';
import { StatusService } from './status.service';

@Component({
    selector: 'jhi-status-dialog',
    templateUrl: './status-dialog.component.html'
})
export class StatusDialogComponent implements OnInit {

    status: Status;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private statusService: StatusService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.status.id !== undefined) {
            this.subscribeToSaveResponse(
                this.statusService.update(this.status));
        } else {
            this.subscribeToSaveResponse(
                this.statusService.create(this.status));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<Status>>) {
        result.subscribe((res: HttpResponse<Status>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: Status) {
        this.eventManager.broadcast({ name: 'statusListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-status-popup',
    template: ''
})
export class StatusPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private statusPopupService: StatusPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.statusPopupService
                    .open(StatusDialogComponent as Component, params['id']);
            } else {
                this.statusPopupService
                    .open(StatusDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
