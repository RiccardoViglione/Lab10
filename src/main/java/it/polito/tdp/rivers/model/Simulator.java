package it.polito.tdp.rivers.model;

import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.Event.EventType;

public class Simulator {private Model model;
public Simulator() {
this.model=new Model();
}
//coda venti
	private PriorityQueue<Event> queue;
	
	//modello mondo
	private List<Flow> fIn;
	private float Q;
	private float C;
	private float fOut;
	private float fOutMin;
	//input
	private River r;
	private float k;
	private float fMed;
	//output
	private float cMed;
	private int giorni;
	
	
	//inizaliszzo
	public void setR(River r) {
		this.r = r;
	}
	public void setK(float k) {
		this.k = k;
	}
	public void setfMed(float fMed) {
		this.fMed = fMed*3660*24;
	}
	
	public void run(){
		this.queue=new PriorityQueue<Event>();
		//stato iniziale
		this.Q=this.k*this.fMed*30;
		this.C=this.Q/2;
		this.fOutMin=(float)(0.8*this.fMed);
		this.cMed=0;
		this.giorni=0;
		
		//evnti iniziali
		this.fIn=this.model.getFlows(r);
		for(Flow f:fIn) {
			this.queue.add(new Event(f.getDay(),f,EventType.ENTRATA));
		}
		//ciclo di simulazione
		while(!this.queue.isEmpty()) {
			Event e=this.queue.poll();
			this.processEvent(e);
		}
	}
	private void processEvent(Event e) {
		switch(e.getType()) {
		
		case ENTRATA:
			this.C+=e.getF().getFlow();
			if(this.C>this.Q) {
				this.queue.add(new Event(e.getDate(),e.getF(),EventType.TRACIMAZIONE));
			}
			int p=(int) (Math.random()*100);
			if(p<5)
				this.queue.add(new Event (e.getDate(),e.getF(),EventType.IRRIGAZIONE));
			else
				this.queue.add(new Event(e.getDate(),e.getF(),EventType.USCITA));
			
			break;
		case USCITA:
			if(this.C<this.fOutMin) {
				this.giorni++;
				this.C=0;
				this.cMed+=this.C;
			}
			else {
				this.C-=this.fOutMin;
				this.cMed+=this.C;
			}
			
			break;
		case TRACIMAZIONE:
			float diff=this.C-this.Q;
			this.C-=diff;
			
			break;
		case IRRIGAZIONE:
			this.fOut=10*this.fOutMin;
			if(this.fOut>C) {
				this.giorni++;
				this.fOut=this.C;
				this.C=0;
				this.cMed+=this.C;
			}else {
				this.C-=this.fOut;
				this.cMed+=this.C;
			}
			
			break;
			
		}
	}
	public int giorni() {
		return giorni;
	}
	
	public float cMed() {
		return cMed/this.fIn.size();
	}
}
