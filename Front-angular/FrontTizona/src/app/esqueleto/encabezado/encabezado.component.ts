import { Component, OnInit } from "@angular/core";
import { environment } from "src/environments/environment";

@Component({
  selector: "app-encabezado",
  templateUrl: "./encabezado.component.html",
  styles: [],
})
export class EncabezadoComponent implements OnInit {
  public titulo = environment.title;
  constructor() {}

  ngOnInit() {}
}
