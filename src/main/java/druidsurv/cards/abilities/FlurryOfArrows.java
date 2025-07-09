package druidsurv.cards.abilities;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractPowerCostCard;

import static druidsurv.ModFile.makeID;

public class FlurryOfArrows extends AbstractPowerCostCard {
    public final static String ID = makeID("FlurryOfArrows");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public FlurryOfArrows() {
        super(ID, 4, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY, "StormOfArrows_CardArt");
        baseDamage = 10;
        baseMagicNumber = magicNumber = 1;
        retain = true;
        isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        allDmg(AbstractGameAction.AttackEffect.SLASH_VERTICAL);
        //this.cost = 4;
    }

    public void triggerWhenDrawn() {

    }

    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        /*if (c.hasTag(BLOON) && this.cost > 0) {
            this.cost -= c.costForTurn;
            this.cost = Math.max(0, this.cost);
        }*/

    }

    @Override
    public void upp() {
        upgradeBaseCost(3);
    }
}