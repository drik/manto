import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MantoSharedModule } from '../../shared';
import { MantoAdminModule } from '../../admin/admin.module';
import {
    MantisImportService,
    MantisImportPopupService,
    MantisImportComponent,
    MantisImportDetailComponent,
    MantisImportDialogComponent,
    MantisImportPopupComponent,
    MantisImportDeletePopupComponent,
    MantisImportDeleteDialogComponent,
    mantisImportRoute,
    mantisImportPopupRoute,
} from './';

const ENTITY_STATES = [
    ...mantisImportRoute,
    ...mantisImportPopupRoute,
];

@NgModule({
    imports: [
        MantoSharedModule,
        MantoAdminModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        MantisImportComponent,
        MantisImportDetailComponent,
        MantisImportDialogComponent,
        MantisImportDeleteDialogComponent,
        MantisImportPopupComponent,
        MantisImportDeletePopupComponent,
    ],
    entryComponents: [
        MantisImportComponent,
        MantisImportDialogComponent,
        MantisImportPopupComponent,
        MantisImportDeleteDialogComponent,
        MantisImportDeletePopupComponent,
    ],
    providers: [
        MantisImportService,
        MantisImportPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MantoMantisImportModule {}
