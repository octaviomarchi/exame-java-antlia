import {Component, Input, OnInit} from '@angular/core';
import {MovimentoManual} from "../../models/movimento-manual";

@Component({
  selector: 'app-manual-movements-grid',
  templateUrl: './manual-movements-grid.component.html',
  styleUrls: ['./manual-movements-grid.component.css']
})
export class ManualMovementsGridComponent implements OnInit {

  @Input()
  movimentos: MovimentoManual[] = new Array<MovimentoManual>();

  constructor() { }

  ngOnInit(): void {
  }
}
