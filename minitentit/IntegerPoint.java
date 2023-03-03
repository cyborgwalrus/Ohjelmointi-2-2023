package minitentit;

class IntegerValue
{
private int num;
public IntegerValue(int inum){
    num = inum;
}
public int getInt(){
    return this.num;
}
public IntegerValue add(IntegerValue other){
    int total = this.num;
    total += other.getInt();
    return new IntegerValue(total);
}
}

class IntegerPoint
{
private IntegerValue x;
private IntegerValue y;
public IntegerPoint(IntegerValue ix, IntegerValue iy){
    x = ix;
    y = iy;
}
public IntegerValue getX(){
    return this.x;
}
public IntegerValue getY(){
    return this.y;
}
public IntegerPoint add(IntegerPoint other){
    int x = this.getX().getInt();
    int y = this.getY().getInt();
    x += other.getX().getInt();
    y += other.getY().getInt();

    return new IntegerPoint(new IntegerValue(x),new IntegerValue(y));
}
public static void main(String args[]){
    IntegerPoint ip1 = new IntegerPoint(new IntegerValue(-1), new IntegerValue(-2));
IntegerPoint ip2 = new IntegerPoint(new IntegerValue(14), new IntegerValue(13));
IntegerPoint ip3 = ip1.add(ip2);
System.out.println(ip3.getX().getInt());
}
}
