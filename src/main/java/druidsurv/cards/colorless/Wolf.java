package druidsurv.cards.colorless;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AccuracyPower;
import druidsurv.cards.AbstractEasyCard;

import java.util.Objects;

import static druidsurv.ModFile.makeID;
import static druidsurv.cards.cardvars.CardTags.DISCOUNT;

public class Wolf extends AbstractEasyCard {
    public final static String ID = makeID("Wolf");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Wolf() {
        super(ID, 0, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY, CardColor.COLORLESS, "Wolf_CardArt");

        if (AbstractDungeon.player != null && AbstractDungeon.player.hasPower("Accuracy")) {
            this.baseDamage = 4 + (AbstractDungeon.player.getPower("Accuracy")).amount;
        }
        else {
            this.baseDamage = 4;
        }
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    public void triggerOnEndOfPlayerTurn() {
        for (int i = 0; i < AbstractDungeon.player.drawPile.size(); i++) {
            AbstractCard c = AbstractDungeon.player.drawPile.group.get(i);
            if (Objects.equals(c.cardID, makeID("Wolf")))
            {
                AbstractDungeon.player.drawPile.removeCard(this);
                addToBot((AbstractGameAction)new ReducePowerAction(AbstractDungeon.player, AbstractDungeon.player, AccuracyPower.POWER_ID, this.magicNumber));

            }
        }
    }

    public void triggerOnExhaust() {

    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}