import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PerfilComponent} from "./perfil/perfil.component";
import {CadastroComponent} from "./cadastro/cadastro.component";

const routes: Routes = [
  {path: 'perfil', component: PerfilComponent},
  {path: 'cadastro', component: CadastroComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioRoutingModule {
}
