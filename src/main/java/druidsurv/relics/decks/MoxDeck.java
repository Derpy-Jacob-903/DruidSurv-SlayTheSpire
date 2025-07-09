package druidsurv.relics.decks;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
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

public class MoxDeck extends AbstractEasyRelic {
    public static final String ID = makeID("MoxDeck");
    CardGroup sideDeck = new CardGroup(CardGroup.CardGroupType.DRAW_PILE);
    Boolean loss = true;
    public MoxDeck() {
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

    public void onEquip() {
        resetDeck();
    }
    public void onUnequip() {
        if (loss) {AbstractDungeon.player.masterHandSize++;}
        AbstractDungeon.player.masterHandSize++;
    }
    public void atBattleStart() {
        resetDeck();
        setLoss();
        AbstractPlayer p = AbstractDungeon.player;
        ArrayList<AbstractCard> easyCardList = new ArrayList<>();
        atb(new EasyModalChoiceAction(easyCardList));
    }

    public void atTurnStart() {
        if (sideDeck.isEmpty()) { unsetLoss(); }
        else { makeInHand(sideDeck.getTopCard());}
    }
    public void setLoss() {
        if (!loss) {AbstractDungeon.player.masterHandSize--;}
        loss = true;
    }
    public void unsetLoss() {
        if (loss) {AbstractDungeon.player.masterHandSize++;}
        loss = false;
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


    public void resetDeck(){
        ArrayList<AbstractCard> randMoxes = new ArrayList<AbstractCard>();
        randMoxes.add(new MoxGreenVessel());
        randMoxes.add(new MoxRubyVessel());
        randMoxes.add(new MoxBlueVessel());

        sideDeck.addToTop(new MoxGreenVessel());
        sideDeck.addToTop(new MoxGreenVessel());
        sideDeck.addToTop(new MoxRubyVessel());
        sideDeck.addToTop(new MoxRubyVessel());
        sideDeck.addToTop(new MoxBlueVessel());
        sideDeck.addToTop(new MoxBlueVessel());
        sideDeck.addToTop(getRandomItem(randMoxes));
        sideDeck.addToTop(getRandomItem(randMoxes));
        sideDeck.addToTop(getRandomItem(randMoxes));
        sideDeck.addToTop(getRandomItem(randMoxes));
        sideDeck.shuffle();
    }
}


