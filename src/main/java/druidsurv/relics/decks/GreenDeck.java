package druidsurv.relics.decks;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.relics.AbstractEasyRelic;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.modID;

public class GreenDeck extends AbstractEasyRelic {
    public static final String ID = makeID("GreenDeck");

    public GreenDeck() {
        super(ID, RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        if (c.tags.contains(CardTags.MONKEY)) {
            AbstractPlayer p = AbstractDungeon.player;
            addToBot( new ApplyPowerAction(p, p, (AbstractPower) new DrawCardNextTurnPower(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
        }
    }

    public void atTurnStart() {
        flash();
        addToTop(new GainEnergyAction(1));
    }

    public void onPlayerEndTurn() {
        flash();
        addToTop((AbstractGameAction)new LoseEnergyAction(3));
    }

    public void onManualDiscard()
    {
        flash();
        addToTop((AbstractGameAction)new LoseEnergyAction(1));
    }

    private static final String starterReplaceIDA = "Deck";
    private static final String starterReplaceIDB = modID + ":";

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
}


