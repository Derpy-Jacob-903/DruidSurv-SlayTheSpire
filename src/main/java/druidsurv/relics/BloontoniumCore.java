/*    */ package druidsurv.relics;
/*    */ 
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.orbs.AbstractOrb;
/*    */
import com.megacrit.cardcrawl.relics.AbstractRelic;
import druidsurv.orbs.BloontoniumOrb;

/*    */
/*    */ public class BloontoniumCore extends AbstractRelic {
/*    */   public BloontoniumCore() {
/* 10 */     super("BloontoniumCore", "frozenOrb.png", RelicTier.BOSS, LandingSound.CLINK);
/*    */   }
/*    */   public static final String ID = "BloontoniumCore";
/*    */   
/*    */   public String getUpdatedDescription() {
/* 15 */     return this.DESCRIPTIONS[0];
/*    */   }
/*    */ 
/*    */   
/*    */   public void onPlayerEndTurn() {
/* 20 */     if (AbstractDungeon.player.hasEmptyOrb()) {
/* 21 */       flash();
/* 22 */       AbstractDungeon.player.channelOrb((AbstractOrb)new BloontoniumOrb());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   //public boolean canSpawn() {
/* 28 */     //return AbstractDungeon.player.hasRelic("Cracked Core");
/*    */   //}
/*    */ 
/*    */   
/*    */   public AbstractRelic makeCopy() {
/* 33 */     return new BloontoniumCore();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\SlayTheSpire\desktop-1.0.jar!\com\megacrit\cardcrawl\relics\FrozenCore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */