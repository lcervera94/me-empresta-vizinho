import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {CondominioModel} from "../model/condominio.model";
import {CategoriaModel} from "../model/categoria.model";
import {ProdutoModel} from "../model/produto.model";


@Injectable()
export class ProdutoService {

  constructor(private http: Http) {
  }

  extractData(response) {
    return response.json();
  }

  getAllCategories(): Observable<CategoriaModel[]> {
    return this.http.get('http://localhost:8080/categoria/selectAll').map(this.extractData);
  }

  insertProduct(product: ProdutoModel) {
    return this.http.post('http://localhost:8080/produto/insere', product);
  }

  getProdutoPorUsuario(idUsuario: number): Observable<ProdutoModel[]> {
    return this.http.get('http://localhost:8080/produtos/getById?id=' + idUsuario).map(this.extractData);
  }

  produtoDevolveu(id: number): Observable<boolean> {
    return this.http.get('http://localhost:8080/produto/devolveu?id=' + id).map(this.extractData);
  }

  produtosComigo(id: number): Observable<ProdutoModel[]>{
    return this.http.get('http://localhost:8080/produto/comigo?id=' + id).map(this.extractData);
  }

  produtoDevolver(id: number): Observable<boolean> {
    return this.http.get('http://localhost:8080/produto/devolver?id=' + id).map(this.extractData);
  }

  pedidos(id: number): Observable<ProdutoModel[]>{
    return this.http.get('http://localhost:8080/produto/pedidos?id=' + id).map(this.extractData);
  }

  negar(id: number):Observable<boolean>{
    return this.http.get('http://localhost:8080/produto/negar?id='+id).map(this.extractData);
  }

  aceitar(id: number):Observable<boolean>{
    return this.http.get('http://localhost:8080/produto/aceitar?id='+id).map(this.extractData);
  }


}
