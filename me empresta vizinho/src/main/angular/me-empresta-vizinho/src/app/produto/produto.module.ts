import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProdutoRoutingModule} from './produto-routing.module';
import {CadastroComponent} from './cadastro/cadastro.component';
import {
  ButtonModule, CalendarModule, DropdownModule, InputTextareaModule, InputTextModule,
  SpinnerModule
} from 'primeng/primeng';

@NgModule({
  imports: [
    CommonModule,
    ProdutoRoutingModule,
    DropdownModule,
    InputTextModule,
    SpinnerModule,
    CalendarModule,
    ButtonModule,
    InputTextareaModule
  ],
  declarations: [CadastroComponent]
})
export class ProdutoModule {
}
