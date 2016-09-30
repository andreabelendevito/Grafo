
public class Grafo {
	
	boolean[][] matriz;
	private int cantVertices;
	private int cantAristas;
	
	Grafo(int vertices){
		if(vertices <=0 )
			throw new IllegalArgumentException("La cant de vertices debe ser positiva");
		matriz = new boolean[vertices][vertices];
		cantVertices=vertices;
	}
	
	public void crearArista(int v1, int v2){
		if(!existeArista(v1,v2)){
			matriz[v1][v2]=true;
			matriz[v2][v1]=true;
			
			cantAristas++;
		}
		
	}
	private void chequearArista(int v1, int v2) {
		if(v1<0|| v2<0 )
			throw new IllegalArgumentException("La arista debe ser positiva"+ v1+";"+v2);
		if(v1>=cantVertices || v2>=cantVertices)
			throw new IllegalArgumentException("La cant de vertices debe existir");
	}
	public void eliminarArista(int v1, int v2){
		chequearArista(v1, v2);
		if(existeArista(v1,v2))
			cantAristas--;
		matriz[v1][v2]=false;
		matriz[v2][v1]=false;
		
	}
	public boolean existeArista(int v1,int v2){
		
		chequearArista(v1,v2);
		return(matriz[v1][v2]& matriz[v2][v1]);
	}
	public int getCantAristas(){
		return this.cantAristas;
	}

}
