import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MantoSharedModule } from '../../shared';
import {
    MantisApproverService,
    MantisApproverPopupService,
    MantisApproverComponent,
    MantisApproverDetailComponent,
    MantisApproverDialogComponent,
    MantisApproverPopupComponent,
    MantisApproverDeletePopupComponent,
    MantisApproverDeleteDialogComponent,
    mantisApproverRoute,
    mantisApproverPopupRoute,
} from './';

const ENTITY_STATES = [
    ...mantisApproverRoute,
    ...mantisApproverPopupRoute,
];

@NgModule({
    imports: [
        MantoSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        MantisApproverComponent,
        MantisApproverDetailComponent,
        MantisApproverDialogComponent,
        MantisApproverDeleteDialogComponent,
        MantisApproverPopupComponent,
        MantisApproverDeletePopupComponent,
    ],
    entryComponents: [
        MantisApproverComponent,
        MantisApproverDialogComponent,
        MantisApproverPopupComponent,
        MantisApproverDeleteDialogComponent,
        MantisApproverDeletePopupComponent,
    ],
    providers: [
        MantisApproverService,
        MantisApproverPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MantoMantisApproverModule {}
