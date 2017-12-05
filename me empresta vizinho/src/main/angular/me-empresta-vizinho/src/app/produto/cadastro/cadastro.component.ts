import {Component, OnInit} from '@angular/core';
import {SelectItem} from "primeng/primeng";
import {ProdutoService} from "../produto.service";
import {ProdutoModel} from "../../model/produto.model";

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  categories: SelectItem[] = [
    {label: 'Selecione...', value: null}
  ];
  selectedCategory: number = null;
  product: ProdutoModel = {
    idProduto: null,
    nomeProduto: null,
    descProduto: null,
    data_fim: null,
    data_inicio: null,
    idCategoria: null,
    idUsuario: null,
    link_imagem: null,
    vl_preco: null,
    nomeTomador: null,
    idTomador: null,
    emprestado: false
  };
  initialDate = new Date();
  finalDate = new Date();

  constructor(private produtoService: ProdutoService) {
  }

  ngOnInit() {
    this.getAllCategories();
  }

  getAllCategories() {
    this.produtoService.getAllCategories().forEach((observable) => {
      observable.forEach((category) => {
        this.categories.push({label: category.nomeCategoria, value: category.id});
      });
    });
  }

  salvar() {
    // this.product.data_inicio = this.initialDate.getTime();
    // this.product.data_fim = this.finalDate.getTime();
    this.product.idUsuario = 1;
    if (this.produtoService.insertProduct(this.product).subscribe()) {
      alert('Produto inserido com sucesso');
    }
  }

}
