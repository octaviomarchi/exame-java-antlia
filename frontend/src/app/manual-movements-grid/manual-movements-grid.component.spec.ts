import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManualMovementsGridComponent } from './manual-movements-grid.component';

describe('ManualMovementsGridComponent', () => {
  let component: ManualMovementsGridComponent;
  let fixture: ComponentFixture<ManualMovementsGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManualMovementsGridComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManualMovementsGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
