import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CadastroComponent} from "./cadastro/cadastro.component";
import {BuscaComponent} from "./busca/busca.component";

const routes: Routes = [
  {path:'cadastro', component: CadastroComponent},
  {path:'busca', component: BuscaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutoRoutingModule { }
