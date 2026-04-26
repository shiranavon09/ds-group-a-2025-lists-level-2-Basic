class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
  	public static Node<Integer> maxThirds(Node<Integer> head) 
	{
        if (head==null) return null;
        Node<Integer> resultHead=null;
        Node<Integer> resultTail=null;
        Node<Integer> current=head;
        int index = 0;
        while(current!=null) 
        {
            int max=current.getValue();
            int maxIndex=index;
            Node<Integer> temp=current;
            int count=0;
            while(temp!=null&&count<3) 
            {
                if(temp.getValue()>max) 
                {
                    max=temp.getValue();
                    maxIndex=index+count;
                }
                temp=temp.getNext();
                count++;
            }
            Node<Integer> newNode=new Node<>(maxIndex);
            if(resultHead==null) 
            {
                resultHead=newNode;
                resultTail=newNode;
            } 
            else 
            {
                resultTail.setNext(newNode);
                resultTail=newNode;
            }
            for(int i=0; i<3&&current!=null; i++) 
            {
                current=current.getNext();
                index++;
            }
        }
        return resultHead;
    }
    public static Node<Integer> minusMaxThirds(Node<Integer> n)
    {
        Node<Integer> l = maxThirds(n);
        Node<Integer> place = n;
        Node<Integer> prev = null;
        int index = 0;
        while (place != null && l != null)
        {
            if (index == l.getValue())
            {
                if (prev == null)
                {
                    n = n.getNext();
                    place = n;
                }
                else
                {
                    prev.setNext(place.getNext());
                    place = place.getNext();
                }
                l = l.getNext();
            }
            else
            {
                prev = place;
                place = place.getNext();
            }
            index++;
        }
    
        return n;
    }
}
