/*
 * 
 */
package mvc.controller;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.json.JSONException;

import mvc.model.DashModel;
import mvc.view.DashView;

public class DashController {

	private DashView _view;
	private DashModel _model;

	public DashController(){
		this._model = new DashModel();
		this._view = new DashView();
		startTasks();
		addListener();
	}

	public void showView(){
		this._view.setVisible(true);
	}

	private void addListener(){

	}

	private void startTasks(){
		GetActualValues getActualValues = new GetActualValues();
		getActualValues.start();
	}

	
	/**
	 * 
	 */
	class SollTemperaturListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {

		}
	}

	

	class GetActualValues extends Thread{
		public void run(){
			
			while(true){
				
				_view.setActualTemperaturs(_model.getActualTemperatureFromVZ());
				
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

