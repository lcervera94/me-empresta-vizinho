import {Component, OnInit} from '@angular/core';
import {SelectItem} from "primeng/primeng";
import {ProdutoService} from "../produto.service";
import {Router} from "@angular/router";
import {ProdutoModel} from "../../model/produto.model";

@Component({
  selector: 'app-busca',
  templateUrl: './busca.component.html',
  styleUrls: ['./busca.component.css']
})
export class BuscaComponent implements OnInit {

  searchCategory: number;
  searchText: string;
  categories: SelectItem[] = [{label: "Selecione", value: null}];
  productGrid: ProdutoModel[] = [];

  constructor(private router: Router,
              private produtoService: ProdutoService) {
  }

  ngOnInit() {
    this.getAllCategories()
  }

  getAllCategories() {
    this.produtoService.getAllCategories().forEach((observable) => {
      observable.forEach((category) => {
        this.categories.push({label: category.nomeCategoria, value: category.id});
      });
    });
  }

  search() {
    let i = 0;
    for (i = 1; i < 15; i++) {
      this.productGrid.push({
        idProduto: 1,
        nomeProduto: 'Livro ' + i,
        descProduto: 'Livro ' + i + ' - ' + i + '50 páginas',
        idCategoria: 49,
        idUsuario: 1,
        vl_preco: 10,
        data_inicio: new Date().getTime(),
        data_fim: new Date().getTime(),
        link_imagem: null
      });
    }
  }

}
