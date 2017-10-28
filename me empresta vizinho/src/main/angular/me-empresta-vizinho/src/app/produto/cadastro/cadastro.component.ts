import {Component, OnInit} from '@angular/core';
import {SelectItem} from "primeng/primeng";

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  categorias: SelectItem[] = [
    {label: 'Selecione...',         value: null},
    {label: 'Livro',                value: 'livro'},
    {label: 'Jogo',                 value: 'jogo' },
    {label: 'Ferramenta',           value: 'ferramenta' },
    {label: 'Utilidade doméstica',  value: 'utilDomest'},
    {label: 'Roupa',                value: 'roupa' },
    {label: 'Acessórios',           value: 'acessorio' }
    ];

  constructor() {
  }

  ngOnInit() {
  }

}
