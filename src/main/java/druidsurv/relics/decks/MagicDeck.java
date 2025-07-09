package druidsurv.relics.decks;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.powers.WizardPower;
import druidsurv.relics.AbstractEasyRelic;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.modID;

@AutoAdd.Ignore
public class MagicDeck extends AbstractEasyRelic {
    public static final String ID = makeID("MagicDeck");

    public MagicDeck() {
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

    public void onPlayerEndTurn() {
        AbstractPlayer p = AbstractDungeon.player;
        addToBot((AbstractGameAction) new ApplyPowerAction(p, p, (AbstractPower) new WizardPower(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
    }

    public void atBattleStart() {
        AbstractPlayer p = AbstractDungeon.player;
        addToBot((AbstractGameAction) new ApplyPowerAction(p, p, (AbstractPower) new WizardPower(p, -2), -2, true, AbstractGameAction.AttackEffect.NONE));
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
}


