import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class PBS {
     Node head=null;

     class Node {
         Product data;
         Node next;

         Node(Product data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addProduct(Product product) {
        Node newNode = new Node(product);
        String id=product.getid();
        double price=product.getprice();
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            Node temp = null;

            while (current != null) {
                double Price=current.data.getprice();
                if (current.data.getName().equalsIgnoreCase(product.getName()) && current.data.getid().equalsIgnoreCase(product.getid()) && Double.toString(price).equalsIgnoreCase(Double.toString(Price))) {
                    int q=product.getQuantity()+current.data.getQuantity();
                    updateQuantity(id, q);
                    return;
                }
                else{
                temp = current;
                current = current.next;
                }
            }
            temp.next = newNode;
        }
    }
    

    public void deleteProduct(String productID) {
        if (head == null) {
            System.out.println("\t\t\t\t\t\t\t !! EMPTY CART !!");
            return;
        }

        if (head.data.getid().equalsIgnoreCase(productID)) {
            System.out.println("\n\t\t\t\t\t\t!! "+head.data.getName()+" HAS BEEN DELETED !! \n");
            head = head.next;
            return;
        }

        Node current = head;
        Node q = null;
        
        while (current != null && !current.data.getid().equalsIgnoreCase(productID)) {
            q = current;
            current = current.next;
        }

        if (current != null) {
            System.out.println("\n\t\t\t\t\t\t\t!!"+current.data.getName()+" HAS BEEN DELETED !!\n");
            q.next = current.next;
        } else {
            System.out.println("\n\t\t\t\t\t\t\t!! NO SUCH PRODUCT FOUND !!\n");
        }
    }


    public double calculateTotalCost() {
        double total = 0;
        Node current = head;
        while (current != null) {
            total += current.data.getTotalCost();
            current = current.next;
        }
        return total;
    }

    public void displayCart() {
        Node current = head;
        if(current==null)
        {
            System.out.println("\n\t\t\t\t\t\t\t:: CART IS EMPTY :: \n");
        }
        while (current != null)
        { 
        System.out.println(" "+String.format("%117s","").replace(" ","-"));
        System.out.println(" |"+"\t\t\t\t\t\t\t:: YOUR CART ::"+"\t\t\t\t\t\t\t|");
        System.out.println(" "+String.format("%117s","").replace(" ","="));
        System.out.println(" |"+String.format("%115s","\t|"));
        System.out.println(" |"+"\t\t\t\t\t\t\tPRODUCT ID: "+String.format("%-49s",current.data.getid())+"|");
        System.out.println(" |"+"\t\t\t\t\t\t\tPRODUCT NAME: "+String.format("%-47s",current.data.getName())+"|");
        System.out.println(" |"+"\t\t\t\t\t\t\tPRODUCT QUANTITY: "+String.format("%-43s",current.data.getQuantity())+"|");
        System.out.println(" |"+"\t\t\t\t\t\t\tPRODUCT PRICE: "+String.format("%-46s",current.data.getprice())+"|");
        System.out.println(" |"+String.format("%115s","\t|"));
        System.out.println(" "+String.format("%117s","").replace(" ","-"));
        System.out.format("\n\n");
        current = current.next;
        }
    }
    

    public void updateQuantity(String productID, int newQuantity) {
        Node current = head;
        if(newQuantity==0)
        {
            deleteProduct(productID);
            return;
        }
        else{
            if(head==null)
            {
               
                System.out.println("\n\t\t\t\t\t\t\t!! CART IS EMPTY !!\n");
            }else{
                while (current!= null) {
                    if (current.data.getid().equalsIgnoreCase(productID) ) {
                        current.data.setQuantity(newQuantity);
                        return;
                    }
                    else{
                        System.out.println("\n\t\t\t\t\t\t\t!! NO SUCH PRODUCT FOUND !!\n");
                    }
                    current = current.next;
                }
            }
    }
      
    }

    public int check(String id)
    {
     Node current=head;
     while(current!=null){
     if(current.data.getid().equalsIgnoreCase(id))
     {
       return 1;
     }
     current=current.next;
     }
      return -1;
    }

    public String getSearchname(String id)
    {
     Node current=head;
     while(current!=null){
     if(current.data.getid().equalsIgnoreCase(id))
     {
       return current.data.getName();
     }
     current=current.next;
     }
      return null;
    }

    
    public double getsearchprice(String id)
    {
     Node current=head;
     while(current!=null){
     if(current.data.getid().equalsIgnoreCase(id))
     {
       return current.data.getprice();
     }
     current=current.next;
     }
      return -1;
    }

    public int getsearchQty(String id)
    {
     Node current=head;
     while(current!=null){
     if(current.data.getid().equalsIgnoreCase(id))
     {
       return current.data.getQuantity();
     }
     current=current.next;
     }
      return -1;
    }

       public boolean isempty()
    {
        if(head==null)
        {
       return true;
        }
        return false;
    }

    

    public void GenerateBill() throws Exception
    {
          Scanner sc=new Scanner(System.in);
          Node current=head;
          double overAllPrice=0;
        if(current==null)
        {
            System.out.println("\n\t\t\t\t\t\t\t:: CART IS EMPTY :: \n");
        }else{
       System.out.println("\n");
       Thread t=new Thread();
       t.start();
       t.setName("\t\t\t\t\t\t\t█▒▒▒▒▒▒▒▒▒10%\n\n");
       System.out.print(t.getName()); 
       Thread.sleep(2000);
       t.setName("\t\t\t\t\t\t\t█████▒▒▒▒▒50%\n\n");
       System.out.print(t.getName());
       Thread.sleep(2000);
       t.setName("\t\t\t\t\t\t\t██████████100%\n\n");
       System.out.print(t.getName());
       Thread.sleep(2000);
       t.setName("\t\t\t\t\t\t :: GENARATING BILL..... ::\n");
       System.out.print(t.getName()); 
       Thread.sleep(4000);
        System.out.println("\n\n "+String.format("%117s","").replace(" ","-"));
        System.out.println("  "+"\t\t\t\t\t\t\t <><> TAX INVOICE <><>"+"\t\t\t\t\t\t\t\t ");
        LocalDateTime dt=LocalDateTime.now();
        DateTimeFormatter df= DateTimeFormatter.ofPattern("dd-mm-yyyy");
        DateTimeFormatter tf= DateTimeFormatter.ofPattern("hh:mm:ss a");
        System.out.println("  "+dt.format(df)+" ("+dt.format(tf)+")");
        System.out.println(" "+String.format("%117s","").replace(" ","="));
        System.out.print("\n  Product ID \t\tName\t\t\t\tQuantity\t\tRate \t\t\tTotal Price\n");  
        System.out.println(" "+String.format("%117s","").replace(" ","-"));
        while(current!=null)
        {
            current.data.display();
            overAllPrice=overAllPrice+current.data.getTotalCost();
            current=current.next;
        }
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t Total Amount (Rs.) " +overAllPrice);  
        double discount = overAllPrice*2/100;  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t Discount (Rs.) " +discount);  
        double subtotal = overAllPrice-discount;   
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t Subtotal "+subtotal);  
        double sgst=overAllPrice*12/100;  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t SGST (%) "+sgst);  
        double cgst=overAllPrice*12/100;  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t CGST (%) "+cgst);  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t Invoice Total " +(subtotal+cgst+sgst));  
        System.out.println(" "+String.format("1%117s","").replace(" ","="));
       
    }

 

    }

    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        PBS pbs=new PBS();
        PBS store=new PBS();

        store.addProduct(new Product("1","PARLE NUTRICRUNCH(1kg)", 300));
        store.addProduct(new Product("2","AMUL PANNEER(100g)", 200));
        store.addProduct(new Product("3","NATRAJ PENCIL(set of 12)", 50));
        store.addProduct(new Product("4","OREO CHOCOLATE BISCUIT(1kg)", 300));
        store.addProduct(new Product("5","CAR DUSTER",350));
        store.addProduct(new Product("6","SAMSUNG SMART WATCH", 1500));
        store.addProduct(new Product("7","NIKE MENS SPORT SHOES", 3000));
        store.addProduct(new Product("8","MILTON THERMOSTEEL BOTTLE(1kg)", 1000));

        System.out.println("\n\t\t\t\t\t\t:: WELCOME TO PRODUCT BILLING SYSTEM ::");
        boolean b=true;
        while(b)
      {
       System.out.println(" "+String.format("\t\t\t\t%73s","").replace(" ","-"));
       System.out.println("\t\t\t\t|\t\t\t: SELECT TASK TO PERFORM :\t\t\t|");
       System.out.println(" "+String.format("\t\t\t\t%73s","").replace(" ","="));
       System.out.println("\t\t\t\t|\t\t\t1. ---> INSERT PRODUCT\t\t\t\t|");
       System.out.println("\t\t\t\t|\t\t\t2. ---> DELETE PRODUCT\t\t\t\t|");
       System.out.println("\t\t\t\t|\t\t\t3. ---> UPDATE PRODUCT QUANTITY\t\t\t|");
       System.out.println("\t\t\t\t|\t\t\t4. ---> VIEW CART\t\t\t\t|");
       System.out.println("\t\t\t\t|\t\t\t5. ---> GENERATE BILL\t\t\t\t|");
       System.out.println("\t\t\t\t|\t\t\t6. ---> EXIT\t\t\t\t\t|");
       System.out.println(" "+String.format("\t\t\t\t%73s","").replace(" ","-"));
                System.out.print("\n\t\t\t\tSELECT : ");
                String choice=sc.next();
                System.out.format("\n");
            switch(Integer.parseInt(choice))
            {
                case 1:

                System.out.println("\n\t\t\t\t\t    <><><> : ENTER PRODUCT DETAIL : <><><>");  
                System.out.print("\t\t\t\t\t\t\tProduct ID: "); 
                String id = sc.next();
                if(store.check(id)==1)
                {
                String name=store.getSearchname(id);
                double price=store.getsearchprice(id);
                System.out.println("\t\t\t\t\t-------------------------------------------------");
                System.out.println("\t\t\t\t\t\tProduct Name: "+name);
                System.out.println("\t\t\t\t\t\tPrice (per unit): "+price); 
                System.out.println("\t\t\t\t\t-------------------------------------------------");
                System.out.print("\t\t\t\t\t\t\tQuantity: ");  
                int quantity = sc.nextInt();
                System.out.format("\n");
                pbs.addProduct(new Product(name,id,price,quantity));
                }
                else
                {
                    System.out.println("\n\t\t\t\t\t\t\t   !! NO RESULT !!");
                }
                break;
                case 2:
                System.out.print("\n\t\t\t\t\t\t\tENTER PRODUCT ID: ");
                String Productid=sc.next();
                if(pbs.check(Productid)==1)
                {
                String name=pbs.getSearchname(Productid);
                double price=pbs.getsearchprice(Productid);
                int quantity=pbs.getsearchQty(Productid);
                System.out.println("\n\t\t\t\t\t\t <><><> : PRODUCT DETAIL : <><><>");  
                System.out.println("\t\t\t\t\t--------------------------------------------------");
                System.out.println("\t\t\t\t\t\tProduct Name: "+name);
                System.out.println("\t\t\t\t\t\tPrice (per unit): "+price);  
                System.out.println("\t\t\t\t\t\tQuantity: "+quantity);
                System.out.println("\t\t\t\t\t--------------------------------------------------");
                System.out.print("\n\t\t\t\t\t\tDELETE FROM CART??(YES OR NO) : ");
                String y=sc.next();
                if(y.equalsIgnoreCase("yes"))
                {
                System.out.format("\n");
                pbs.deleteProduct(Productid);
                }
                }
                else if(pbs.isempty())
                {
            System.out.println("\n\t\t\t\t\t\t\t:: CART IS EMPTY :: \n");
                }
                else{
                System.out.println("\n\t\t\t\t\t\t\t!! NO SUCH PRODUCT FOUND !!\n");
                }
                System.out.println("\n");
                break;
                case 3:
                System.out.print("\n\t\t\t\t\t\t\tENTER PRODUCT ID: ");
                String ID=sc.next();
                System.out.print("\t\t\t\t\t\t\tENTER NEW QUANTITY: ");
                int Quantity = sc.nextInt();
                if(pbs.check(ID)==1)
                {
                String name=pbs.getSearchname(ID);
                double price=pbs.getsearchprice(ID);
                int quantity=pbs.getsearchQty(ID);
                System.out.println("\n\t\t\t\t\t\t <><><> : PRODUCT DETAIL : <><><>");  
                System.out.println("\t\t\t\t\t-------------------------------------------------");
                System.out.println("\t\t\t\t\t\tProduct Name: "+name);
                System.out.println("\t\t\t\t\t\tPrice (per unit): "+price);  
                System.out.println("\t\t\t\t\t\tPrevious Quantity: "+quantity);
                System.out.println("\t\t\t\t\t-------------------------------------------------");
                System.out.print("\t\t\t\t\t\tUPDATE CART??(YES OR NO) : ");
                String y=sc.next();
                if(y.equalsIgnoreCase("yes"))
                {
                System.out.format("\n");
                pbs.updateQuantity(ID,Quantity);
                }
                }
                 else if(pbs.isempty())
                {
            System.out.println("\n\t\t\t\t\t\t\t:: CART IS EMPTY :: ");
                }
                 else{
               System.out.println("\n\t\t\t\t\t\t\t!! NO SUCH PRODUCT FOUND !!");
                }
                System.out.println("\n");
                break;
                case 4:
                pbs.displayCart();
                break;
                case 5:
                pbs.GenerateBill();
                 System.out.println("\n\t\t\t\t\t\t\t-------SELECT-------");
                 System.out.println("\t\t\t\t\t\t\t   1. -->CANCEL BILL");
                 System.out.println("\t\t\t\t\t\t\t   2. -->CONTINUE BILL");
                    String select=sc.next();
                    if(Integer.parseInt(select)==1)
                    {
                    System.out.println("\t\t\t\t\t\t\t  :: Visit Again ::\n\n");
                    b=false;
                    }
                break;
                case 6:
                b=false;
                break;
                default :
                System.out.println("\n\t\t\t\t\t\t\t !! SELECT CORRECT OPTION !! \n");
                break;
            }
        }
        
        sc.close();
    }
}


class Product {
     String id;
     String name;
     double price;
     int quantity;

    public Product(String id,String name,double price)
    {
        this.id=id;
        this.name = name;
        this.price = price;
    }
    public Product(String name,String id, double price, int quantity) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        double TotalCost=price * quantity;
        return TotalCost;

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getid()
    {
        return id;
    }
    
    public int getQuantity()
    {
        return quantity;
    }

    public Double getprice()
    {
        return price;
    }

    public void display()   
    {
		System.out.println(String.format("   %-21s",id)+String.format("%-35s",name)+String.format("%-20d",quantity)+String.format("%-28.2f",price)+String.format("%.2f",getTotalCost()));
    }  
}
