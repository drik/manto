/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { MantoTestModule } from '../../../test.module';
import { MantisApproverDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/mantis-approver/mantis-approver-delete-dialog.component';
import { MantisApproverService } from '../../../../../../main/webapp/app/entities/mantis-approver/mantis-approver.service';

describe('Component Tests', () => {

    describe('MantisApprover Management Delete Component', () => {
        let comp: MantisApproverDeleteDialogComponent;
        let fixture: ComponentFixture<MantisApproverDeleteDialogComponent>;
        let service: MantisApproverService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [MantoTestModule],
                declarations: [MantisApproverDeleteDialogComponent],
                providers: [
                    MantisApproverService
                ]
            })
            .overrideTemplate(MantisApproverDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(MantisApproverDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(MantisApproverService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
