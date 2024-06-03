import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TravelListComponent } from './pages/travel-list/travel-list.component';
import { MaskComponent } from './component/mask/mask.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { FooterComponent } from './component/footer/footer.component';
import { ExpensesListComponent } from './pages/expenses-list/expenses-list.component';
import { IframeComponent } from './component/iframe/iframe.component';
import { ModalComponent } from './component/modal/modal.component';

@NgModule({
  declarations: [
    AppComponent,
    TravelListComponent,
    MaskComponent,
    NavBarComponent,
    FooterComponent,
    ExpensesListComponent,
    IframeComponent,
    ModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
