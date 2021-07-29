package pe.gob.procalidad.natigu.web.gestion.utilitarios;

import java.io.File;
import java.io.FileInputStream;

public class FileValidator {
	
		
	public static  boolean validFileHead(String ruta) throws Exception {
   	 
   	 FileInputStream ins_ = new FileInputStream(ruta);
   	 try {
   	 int readHead[]=new int[4];
   	 	String headFileType[]= new String[]{"37806870","20820717224","807534"};
		 //int MAGIC[] = new int[]{80,75,3,4}; // docx
		 String headFile="";
		 String headFilePdf="37806870";
		 String headFileDoc="20820717224";
		 String headFileDocx="807534";
		 
		 // xlsx: 807534
		 
		 boolean resp=false;
		 
		
	         for(int i = 0; i <readHead.length; ++i){
	        	 String read=String.valueOf(ins_.read());
	        	 int num = Integer.valueOf(read,10);
	        	 readHead[i]=num;	
	        	 headFile+=String.valueOf(num);
	         	}
	         System.out.println("headFile: "+headFile);
	         /*
	         if(!headFile.equals(headFilePdf)&&!headFile.equals(headFileDoc)&&!headFile.equals(headFileDocx)) {
	        	 resp=false;
	         }*/
	         for(int i = 0; i <headFileType.length; ++i){
	        	 if(headFile.equals(headFileType[i])) {
		        	 resp=true;
		        	 break;
		         }
	        	
	         	}
			 return resp;
	        
		 } finally {
			 ins_.close();
	       }
		 
		 
		
	    };
	    
		public static  boolean validFileHeadXlsXlsx(String ruta) throws Exception {
		   	 
		   	 FileInputStream ins_ = new FileInputStream(ruta);
		   	 try {
		   	 int readHead[]=new int[6];
		   	 	String headFileType[]= new String[]{"807534200","807534100","20820717224161177"};
				 //int MAGIC[] = new int[]{80,75,3,4}; // docx
				 String headFile="";
				 
				 // xlsx: 807534,807534100,807534200,807534200
				 
				 boolean resp=false;
				 
				
			         for(int i = 0; i <readHead.length; ++i){
			        	 String read=String.valueOf(ins_.read());
			        	 int num = Integer.valueOf(read,10);
			        	 readHead[i]=num;	
			        	 headFile+=String.valueOf(num);
			         	}
			         System.out.println("headFile: "+headFile);
			         /*
			         if(!headFile.equals(headFilePdf)&&!headFile.equals(headFileDoc)&&!headFile.equals(headFileDocx)) {
			        	 resp=false;
			         }*/
			         for(int i = 0; i <headFileType.length; ++i){
			        	 if(headFile.equals(headFileType[i])) {
				        	 resp=true;
				        	 break;
				         }
			        	
			         	}
					 return resp;
			        
				 } finally {
					 ins_.close();
			       }
				 
				 
				
			    };
			    
			    public static  boolean validFileHeadImagen(String ruta) throws Exception {
				   	 
				   	 FileInputStream ins_ = new FileInputStream(ruta);
				   	 try {
				   	 int readHead[]=new int[6];
				   	 	String headFileType[]= new String[]{"1378078711310","255216255224016"};
						 //int MAGIC[] = new int[]{80,75,3,4}; // docx
						 String headFile="";
						 
						 // xlsx: 807534,807534100,807534200,807534200
						 
						 boolean resp=false;
						 
						
					         for(int i = 0; i <readHead.length; ++i){
					        	 String read=String.valueOf(ins_.read());
					        	 int num = Integer.valueOf(read,10);
					        	 readHead[i]=num;	
					        	 headFile+=String.valueOf(num);
					         	}
					         System.out.println("-----> headFile: "+headFile);
					         /*
					         if(!headFile.equals(headFilePdf)&&!headFile.equals(headFileDoc)&&!headFile.equals(headFileDocx)) {
					        	 resp=false;
					         }*/
					         for(int i = 0; i <headFileType.length; ++i){
					        	 System.out.println("-----> headFile: "+headFile+" headFileType:"+headFileType[i]);
					        	 if(headFile.equals(headFileType[i])) {
						        	 resp=true;
						        	 break;
						         }
					        	
					         	}
							 return resp;
					        
						 } finally {
							 ins_.close();
					       }
						 
						 
						
					    };

}
