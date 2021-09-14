import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ManualMovementsFormComponent } from './components/manual-movements-form/manual-movements-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ManualMovementsGridComponent } from './components/manual-movements-grid/manual-movements-grid.component';

@NgModule({
  declarations: [
    AppComponent,
    ManualMovementsFormComponent,
    ManualMovementsGridComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
