import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UsuarioRoutingModule} from './usuario-routing.module';
import {PerfilComponent} from './perfil/perfil.component';
import {CadastroComponent} from './cadastro/cadastro.component';
import {UsuarioService} from "./usuario.service";
import {ButtonModule, DropdownModule} from "primeng/primeng";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    UsuarioRoutingModule,
    DropdownModule,
    ButtonModule,
    FormsModule
  ],
  declarations: [PerfilComponent, CadastroComponent],
  providers: [UsuarioService]
})
export class UsuarioModule {
}
