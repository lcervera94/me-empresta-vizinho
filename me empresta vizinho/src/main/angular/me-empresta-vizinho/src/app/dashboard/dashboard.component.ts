import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {UsuarioModel} from "../model/usuario.model";
import {ProdutoModel} from "../model/produto.model";
import {UsuarioService} from "../usuario/usuario.service";
import {ProdutoService} from "../produto/produto.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  searchText: string;
  usuario: UsuarioModel = <UsuarioModel>{};
  meusProdutos: ProdutoModel[] = [];
  produtosComigo: ProdutoModel[] = [];
  pedidos: ProdutoModel[] = [];

  constructor(private router: Router, private usuarioService: UsuarioService, private produtoService: ProdutoService) {
  }

  ngOnInit() {
    this.usuarioService.getUsuario(1).subscribe((observable) => {
      this.usuario = observable;
    });
    this.getProdutos();
    this.getProdutosComigo();
    this.getPedidos();
  }

  editarPerfil() {
    this.router.navigate(['/usuario/perfil']);
  }

  cadastrarProduto() {
    this.router.navigate(['/produto/cadastro']);
  }

  buscarProduto() {
    this.router.navigate(['/produto/busca']);
  }

  devolveu(meuProduto: ProdutoModel) {
    this.produtoService.produtoDevolveu(meuProduto.idProduto).subscribe((observable) => {
      if (observable) {
        this.getProdutos();
      }
    });

  }

  editarProduto(meuProduto: ProdutoModel) {

  }

  devolver(meuProduto: ProdutoModel) {
    this.produtoService.produtoDevolver(meuProduto.idProduto).subscribe((observable) => {
      if (observable) {
        this.getProdutosComigo();
      }
    });
  }

  getProdutos() {
    this.produtoService.getProdutoPorUsuario(1).subscribe((observable) => {
      this.meusProdutos = observable;
    });
  }

  getProdutosComigo() {
    this.produtoService.produtosComigo(1).subscribe((observable) => {
      this.produtosComigo = observable;
    });
  }


  getPedidos() {
    this.produtoService.pedidos(1).subscribe((observable) => {
      this.pedidos = observable;
    });
  }

  negar(produto: ProdutoModel) {
    this.produtoService.negar(produto.idProduto).subscribe((observable) => {
      if (observable) {
        this.getPedidos();
        this.getProdutos();
      }
    });
  }

  aceitar(produto: ProdutoModel) {
    this.produtoService.aceitar(produto.idProduto).subscribe((observable) => {
      if (observable) {
        this.getPedidos();
        this.getProdutos();
      }
    });
  }

}
