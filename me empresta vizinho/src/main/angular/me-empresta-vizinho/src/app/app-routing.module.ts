import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {UsuarioRoutingModule} from "./usuario/usuario-routing.module";
import {ProdutoRoutingModule} from "./produto/produto-routing.module";

const routes: Routes = [
  {path: 'usuario', loadChildren: './usuario/usuario.module#UsuarioModule'},
  {path: 'produto', loadChildren: './produto/produto.module#ProdutoModule'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}

export const routingComponents = [UsuarioRoutingModule, ProdutoRoutingModule];
