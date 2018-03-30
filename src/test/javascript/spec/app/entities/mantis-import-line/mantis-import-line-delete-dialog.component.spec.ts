/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { MantoTestModule } from '../../../test.module';
import { MantisImportLineDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/mantis-import-line/mantis-import-line-delete-dialog.component';
import { MantisImportLineService } from '../../../../../../main/webapp/app/entities/mantis-import-line/mantis-import-line.service';

describe('Component Tests', () => {

    describe('MantisImportLine Management Delete Component', () => {
        let comp: MantisImportLineDeleteDialogComponent;
        let fixture: ComponentFixture<MantisImportLineDeleteDialogComponent>;
        let service: MantisImportLineService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [MantoTestModule],
                declarations: [MantisImportLineDeleteDialogComponent],
                providers: [
                    MantisImportLineService
                ]
            })
            .overrideTemplate(MantisImportLineDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(MantisImportLineDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(MantisImportLineService);
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
