import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Product} from "../../models/product";
import {ProdutoCosif} from "../../models/produto-cosif";
import {MovimentoManualRequest} from "../../models/movimento-manual-request";

@Component({
  selector: 'app-manual-movements-form',
  templateUrl: './manual-movements-form.component.html',
  styleUrls: ['./manual-movements-form.component.css']
})
export class ManualMovementsFormComponent implements OnInit {

  @Input()
  products: Product[];

  @Input()
  codigoCosifArray: ProdutoCosif[] = new Array<ProdutoCosif>();

  @Output()
  codigoProduto: EventEmitter<string> = new EventEmitter<string>();

  @Output()
  submit: EventEmitter<MovimentoManualRequest> = new EventEmitter<MovimentoManualRequest>();

  addProductForm: FormGroup;
  isFormDisabled = true;
  mesRegex = /^(0?[1-9]{1}|1[012])$/;
  anoRegex = /^\d{1,4}$/;
  valorRegex = /^\d+(\.\d{1,2})?$/;

  constructor(
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.addProductForm = this.formBuilder.group({
      mes: ['', [Validators.required, Validators.min(1), Validators.max(12), Validators.pattern(this.mesRegex)]],
      ano: ['', [Validators.required, Validators.pattern(this.anoRegex)]],
      produto: ['', Validators.required],
      cosif: ['', Validators.required],
      valor: ['', [Validators.required, Validators.pattern(this.valorRegex)]],
      descricao: ['', Validators.required]
    });
  }

  onReset(): void {
    this.addProductForm.reset();
  }

  onNew(): void {
    this.isFormDisabled = false;
  }

  OnProdutoSelect(): void {
    this.codigoProduto.emit(this.addProductForm.get('produto').value);
    this.addProductForm.get('cosif').setValue('');
  }

  onSubmit():void {
    let movimentoManualRequest: MovimentoManualRequest = this.addProductForm.value;
    this.submit.emit(movimentoManualRequest);
    this.onReset()
    this.isFormDisabled = true;
  }
}
