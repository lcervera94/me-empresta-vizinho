import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProdutoRoutingModule} from './produto-routing.module';
import {CadastroComponent} from './cadastro/cadastro.component';
import {DropdownModule} from 'primeng/primeng';

@NgModule({
  imports: [
    CommonModule,
    ProdutoRoutingModule,
    DropdownModule
  ],
  declarations: [CadastroComponent]
})
export class ProdutoModule {
}
