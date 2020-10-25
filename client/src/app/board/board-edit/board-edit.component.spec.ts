import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { BoardEditComponent } from './board-edit.component';
import { BoardService } from '../board.service';

describe('BoardEditComponent', () => {
  let component: BoardEditComponent;
  let fixture: ComponentFixture<BoardEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [BoardEditComponent],
      imports: [FormsModule, HttpClientTestingModule, RouterTestingModule],
      providers: [BoardService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
