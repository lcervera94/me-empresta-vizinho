import {Component, OnInit} from '@angular/core';
import {SelectItem} from "primeng/primeng";
import {UsuarioService} from "../usuario.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css'],
  providers: [UsuarioService]
})
export class CadastroComponent implements OnInit {

  user = {nome: 'Lucas'};
  tiposLocal: SelectItem[] = [{label: 'Selecione', value: null}];

  localSelecionado: any;
  numero: string;

  constructor(private usuarioService: UsuarioService,
              private router: Router) {
  }

  ngOnInit() {
    this.localSelecionado = this.tiposLocal[0].value;
    this.getAllTypes();
  }

  salvar() {
    this.usuarioService.salvaUsuario(this.localSelecionado, this.numero).subscribe();
    this.router.navigate(['/produto/cadastro'])
  }

  getAllTypes() {
    this.usuarioService.getAllCondominios().forEach((response) => {
      response.forEach((condominio) => {
        this.tiposLocal.push({label: condominio.nomeCondominio, value: condominio.id});
      });
    });
  }

}
