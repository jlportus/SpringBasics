import { Component, Input, OnInit } from '@angular/core';
import { Artefacto } from '../../models/artefactos/Artefacto';

@Component({
  selector: 'app-ficha',
  templateUrl: './ficha.component.html',
  styles: []
})
export class FichaComponent implements OnInit {
  @Input() ficha: Artefacto
  
  constructor() { }

  ngOnInit() {
  }

}
