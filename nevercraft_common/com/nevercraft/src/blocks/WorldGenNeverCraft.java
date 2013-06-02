package NeverCraft.nevercraft_common.com.nevercraft.src.blocks;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenNeverCraft
  implements IWorldGenerator
{
  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
  {
    switch (world.provider.dimensionId) {
    case -1:
      generateNether();
      break;
    case 0:
      generateSurface(world, random, chunkX * 16, chunkZ * 16);
      break;
    case 1:
      generateEnd();
    }
  }

  public void generateNether()
  {
  }

  public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
  {
    for (int i = 0; i < 30; i++) {
      int randX = chunkX + rand.nextInt(16);
      int randY = rand.nextInt(16);
      int randZ = chunkZ + rand.nextInt(16);

      new WorldGenMinable(Blocks.frugalOre.blockID, 10).generate(world, rand, randX, randY, randZ);
    }
  }

  public void generateEnd()
  {
  }
}