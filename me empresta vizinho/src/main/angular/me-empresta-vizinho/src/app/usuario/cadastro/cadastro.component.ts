import {Component, OnInit} from '@angular/core';
import {SelectItem} from "primeng/primeng";
import {UsuarioService} from "../usuario.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css'],
  providers:[UsuarioService]
})
export class CadastroComponent implements OnInit {

  user = {nome: 'Lucas'};
  tiposLocal: SelectItem[] = [{label: 'Condomínio', value: 'condominio'}];

  constructor(private usuarioService : UsuarioService,
              private router : Router) {
  }

  ngOnInit() {
    this.usuarioService.teste().subscribe();
  }

}
