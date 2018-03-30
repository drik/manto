import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { MantoMantisImportModule } from './mantis-import/mantis-import.module';
import { MantoMantisApproverModule } from './mantis-approver/mantis-approver.module';
import { MantoStateModule } from './state/state.module';
import { MantoStatusModule } from './status/status.module';
import { MantoMantisModule } from './mantis/mantis.module';
import { MantoMantisImportLineModule } from './mantis-import-line/mantis-import-line.module';
import { MantoProjectModule } from './project/project.module';
import { MantoReferentModule } from './referent/referent.module';
import { MantoMantisStatusModule } from './mantis-status/mantis-status.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        MantoMantisImportModule,
        MantoMantisApproverModule,
        MantoStateModule,
        MantoStatusModule,
        MantoMantisModule,
        MantoMantisImportLineModule,
        MantoProjectModule,
        MantoReferentModule,
        MantoMantisStatusModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MantoEntityModule {}
