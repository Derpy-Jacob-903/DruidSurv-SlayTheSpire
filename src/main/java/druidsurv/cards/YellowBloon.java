package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.onedelaybloon;

import static druidsurv.ModFile.makeID;

public class YellowBloon extends AbstractEasyCard {
    public final static String ID = makeID("YellowBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public YellowBloon() {
        super(ID, 3, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 47;
        baseBlock = 15;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.BASIC);
        setBackgroundTexture("druidsurvResources/images/512/bloon_attack.png", "druidsurvResources/images/1024/bloon_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new onedelaybloon(m, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        bloonBlck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(14);
        upgradeBlock(15);
    }
}