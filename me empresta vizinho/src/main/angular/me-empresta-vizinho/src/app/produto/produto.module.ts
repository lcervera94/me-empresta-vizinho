import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProdutoRoutingModule} from './produto-routing.module';
import {CadastroComponent} from './cadastro/cadastro.component';
import {
  ButtonModule, CalendarModule, DataTableModule, DropdownModule, InputTextareaModule, InputTextModule, SharedModule,
  SpinnerModule
} from 'primeng/primeng';
import {ProdutoService} from "./produto.service";
import {FormsModule} from "@angular/forms";
import {BuscaComponent} from './busca/busca.component';

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    ProdutoRoutingModule,
    DropdownModule,
    InputTextModule,
    SpinnerModule,
    CalendarModule,
    ButtonModule,
    DataTableModule,
    SharedModule,
    InputTextareaModule
  ],
  declarations: [CadastroComponent, BuscaComponent],
  providers: [ProdutoService]
})
export class ProdutoModule {
}
