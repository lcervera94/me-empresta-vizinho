import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';


@Injectable()
export class UsuarioService {

  constructor(private http: Http) {
  }

  teste(): Observable<JSON> {
    return this.http.get('http://localhost:8080/testeLucas2').map(res => {
      return res.json().data;
    });
  }

  salvaUsuario(tipoLocal : string, numero : string){
    return this.http.get('http://localhost:8080/usuario/insere?tipoLocal=' + tipoLocal + '&numero=' + numero);
  }

}
