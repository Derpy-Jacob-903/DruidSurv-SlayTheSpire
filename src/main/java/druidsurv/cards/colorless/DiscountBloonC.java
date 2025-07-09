package druidsurv.cards.colorless;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.bloons.BasicBloonPower;
import druidsurv.powers.oldBloons.twodelaybloon;

import static druidsurv.ModFile.makeID;
import static druidsurv.cards.cardvars.CardTags.DISCOUNT;
import static druidsurv.util.Wiz.makeInHand;
import static druidsurv.util.Wiz.shuffleIn;

@Deprecated
@AutoAdd.Ignore
public class DiscountBloonC extends AbstractEasyCard{
    public final static String ID = makeID("DiscountBloonC");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public DiscountBloonC() {
        super(ID, 2, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY, CardColor.COLORLESS, "DiscountBloon_CardArt");
        baseBlock = 0;
        baseDamage = 10;
        baseMagicNumber = magicNumber = 0;
        tags.add(druidsurv.cards.cardvars.CardTags.DISCOUNT);
        tags.add(druidsurv.cards.cardvars.CardTags.ADVANCED);
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        setBackgroundTexture("druidsurvResources/images/512/bloon_attack.png", "druidsurvResources/images/1024/bloon_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if(costForTurn < 1) { this.exhaust = true; }
        //makeInHand(new DiscountBloonC());
        for (int i = 0; i < AbstractDungeon.player.hand.size(); i++) {
            AbstractCard c = AbstractDungeon.player.hand.group.get(i);
            if (c.hasTag(DISCOUNT) )
            {
                if (c.cost > 0) {c.cost--;}
                if (c.costForTurn > 0) {c.costForTurn--;}
                if(cost < 1) { this.exhaust = true; }
                if(costForTurn < 1) { this.exhaust = true; }
            }
        }
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new BasicBloonPower(m, 2, damage, "Discount Bloon"), damage, true, AbstractGameAction.AttackEffect.NONE));
        bloonBlck();
    }

    @Override
    public void upp() {
        //upgradeMagicNumber(-2);
    }
}