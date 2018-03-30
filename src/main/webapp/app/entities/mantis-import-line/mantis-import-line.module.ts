import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MantoSharedModule } from '../../shared';
import {
    MantisImportLineService,
    MantisImportLinePopupService,
    MantisImportLineComponent,
    MantisImportLineDetailComponent,
    MantisImportLineDialogComponent,
    MantisImportLinePopupComponent,
    MantisImportLineDeletePopupComponent,
    MantisImportLineDeleteDialogComponent,
    mantisImportLineRoute,
    mantisImportLinePopupRoute,
} from './';

const ENTITY_STATES = [
    ...mantisImportLineRoute,
    ...mantisImportLinePopupRoute,
];

@NgModule({
    imports: [
        MantoSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        MantisImportLineComponent,
        MantisImportLineDetailComponent,
        MantisImportLineDialogComponent,
        MantisImportLineDeleteDialogComponent,
        MantisImportLinePopupComponent,
        MantisImportLineDeletePopupComponent,
    ],
    entryComponents: [
        MantisImportLineComponent,
        MantisImportLineDialogComponent,
        MantisImportLinePopupComponent,
        MantisImportLineDeleteDialogComponent,
        MantisImportLineDeletePopupComponent,
    ],
    providers: [
        MantisImportLineService,
        MantisImportLinePopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MantoMantisImportLineModule {}
