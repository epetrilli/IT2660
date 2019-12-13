package Graph;
public class Nodes {
        private int nodeValue;
        boolean pushed;
        Nodes( int value)
        {
            nodeValue = value;
        }
        Nodes()
        {

        }
        public int getNodes ()
        {
            return nodeValue;
        }
        public int getNodes ( int value)
        {
            return nodeValue = value;
        }
        public Nodes deepCopy ()
        {
            Nodes clone = new Nodes(nodeValue);
            return clone;
        }
        public boolean getPushed ()
        {
            return pushed;
        }
        public void setPushed ( boolean value)
        {
            pushed = value;
        }

        public void visit ( int vertexNumber)
        {
            System.out.println(this);
        }
    }


