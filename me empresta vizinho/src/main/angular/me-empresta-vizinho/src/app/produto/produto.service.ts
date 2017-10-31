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


}
