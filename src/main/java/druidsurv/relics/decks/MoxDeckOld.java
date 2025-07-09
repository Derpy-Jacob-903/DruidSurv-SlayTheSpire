package druidsurv.relics.decks;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import druidsurv.actions.EasyModalChoiceAction;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.cards.colorless.ModalChoiceMoxBlue;
import druidsurv.cards.colorless.ModalChoiceMoxGreen;
import druidsurv.cards.colorless.ModalChoiceMoxRuby;
import druidsurv.cards.nemesis.mox.*;
import druidsurv.relics.AbstractEasyRelic;

import java.util.ArrayList;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.modID;
import static druidsurv.util.Wiz.*;

public class MoxDeckOld extends AbstractEasyRelic {
    public static final String ID = makeID("MagicDeck");

    public MoxDeckOld() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT);
    }

    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        if (c.tags.contains(CardTags.MONKEY)) {
            AbstractPlayer p = AbstractDungeon.player;
            addToBot((AbstractGameAction) new ApplyPowerAction(p, p, (AbstractPower) new DrawCardNextTurnPower(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
        }
    }

    private static final String starterReplaceIDA = "Deck";
    private static final String starterReplaceIDB = modID + ":";

    public void atBattleStart() {
        AbstractPlayer p = AbstractDungeon.player;
        ArrayList<AbstractCard> easyCardList = new ArrayList<>();
        easyCardList.add(new ModalChoiceMoxGreen());
        easyCardList.add(new ModalChoiceMoxRuby());
        easyCardList.add(new ModalChoiceMoxBlue());
        atb(new EasyModalChoiceAction(easyCardList));
    }

    @Override
    public void obtain() {
        for (int i = 0; i < AbstractDungeon.player.relics.size(); ++i) {
            String relicId = AbstractDungeon.player.relics.get(i).relicId;
            if (relicId != null && relicId.startsWith(starterReplaceIDB) && relicId.endsWith(starterReplaceIDA)) {
                instantObtain(AbstractDungeon.player, i, true);
                break;
            }
        }
        super.obtain();
    }


    public void balss(){
        AbstractDungeon.commonCardPool.addToTop(new MoxGreenLand());
        AbstractDungeon.commonCardPool.addToTop(new MoxGreenVessel());
        AbstractDungeon.commonCardPool.addToTop(new MoxRubyLand());
        AbstractDungeon.commonCardPool.addToTop(new MoxRubyVessel());
        AbstractDungeon.commonCardPool.addToTop(new MoxBlueLand());
        AbstractDungeon.commonCardPool.addToTop(new MoxBlueVessel());
    }
}


