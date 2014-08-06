package mytown.core.utils.teleport;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

/**
 * @author Joe Goett
 */
public class Teleport {
    private int dim;
    private float x, y, z, yaw, pitch;

    public Teleport(int dim, float x, float y, float z, float yaw, float pitch) {
        setDim(dim);
        setPosition(x, y, z);
        setRotation(yaw, pitch);
    }

    public Teleport(int dim, float x, float y, float z) {
        this(dim, x, y, z, 0, 0);
    }

    public void teleport(EntityPlayer pl) {
        if (pl.dimension != dim)
            MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)pl, dim);
        pl.setPositionAndUpdate(x, y, z);
        pl.setPositionAndRotation(x, y, z, yaw, pitch);
    }

    public Teleport setDim(int dim) {
        this.dim = dim;
        return this;
    }

    public Teleport setPosition(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Teleport setRotation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
        return this;
    }

    public int getDim() {
        return dim;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }
}