import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManualMovementsFormComponent } from './manual-movements-form.component';

describe('ManualMovementsFormComponent', () => {
  let component: ManualMovementsFormComponent;
  let fixture: ComponentFixture<ManualMovementsFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManualMovementsFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManualMovementsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
