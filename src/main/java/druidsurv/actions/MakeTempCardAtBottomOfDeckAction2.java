package druidsurv.actions;

import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.unlock.UnlockTracker;


/// Used for the Instinct Potion
public class MakeTempCardAtBottomOfDeckAction2 extends AbstractGameAction {

    AbstractCard card = null;
    public MakeTempCardAtBottomOfDeckAction2(int amount, AbstractCard card) {
        this.setValues(this.target, this.source, amount);
        this.actionType = ActionType.CARD_MANIPULATION;
        this.startDuration = Settings.FAST_MODE ? Settings.ACTION_DUR_FAST : 0.5F;
        this.duration = this.startDuration;
    }

    public void update() {
        if (this.duration == this.startDuration && card != null) {
            for(int i = 0; i < this.amount; ++i) {
                AbstractCard c = card.makeStatEquivalentCopy();
                UnlockTracker.markCardAsSeen(c.cardID);
                if (c.type != AbstractCard.CardType.CURSE && c.type != AbstractCard.CardType.STATUS && AbstractDungeon.player.hasPower("MasterRealityPower")) {
                    c.upgrade();
                }
                AbstractDungeon.player.drawPile.addToBottom(c);
            }
            this.duration -= Gdx.graphics.getDeltaTime();
        }
        this.tickDuration();
    }
}
