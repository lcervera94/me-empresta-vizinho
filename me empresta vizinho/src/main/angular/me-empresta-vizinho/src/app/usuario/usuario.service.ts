import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {CondominioModel} from "../model/condominio.model";


@Injectable()
export class UsuarioService {

  constructor(private http: Http) {
  }

  extractData(response){
    return response.json();
  }

  teste(): Observable<JSON> {
    return this.http.get('http://localhost:8080/testeLucas2').map(res => {
      return res.json();
    });
  }

  salvaUsuario(tipoLocal: string, numero: string) {
    return this.http.get('http://localhost:8080/usuario/insere?tipoLocal=' + tipoLocal + '&numero=' + numero);
  }

  getAllCategories() {
    return this.http.get('http://localhost:8080/categoria/selectAll');
  }

  getAllCondominios() : Observable<CondominioModel[]>{
    return this.http.get('http://localhost:8080/condominio/selectAll').map(this.extractData);

  }

}
