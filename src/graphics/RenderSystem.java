package graphics;

import org.la4j.Vector;
import org.la4j.vector.dense.BasicVector;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.*;
import com.badlogic.gdx.graphics.glutils.*;

public class RenderSystem extends EntitySystem {
	private ImmutableArray<Entity> Entities;
	
	public RenderSystem() {}
	
	// if translating origin to u, return where v would be.
	// This might not be necessary in the long run.
	public Vector translatePoincare(BasicVector u, BasicVector v) {
		Vector pos = (v.multiply(1+2*(u.innerProduct(v))+u.euclideanNorm()*u.euclideanNorm()).add(u.multiply(1-v.euclideanNorm()*v.euclideanNorm())));
		pos = pos.divide(1+2*(u.innerProduct(v))+u.euclideanNorm()*u.euclideanNorm()*v.euclideanNorm()*v.euclideanNorm());
		return pos;
	}
}