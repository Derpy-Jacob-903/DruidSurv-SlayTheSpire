package druidsurv.cards.monkeys.magick;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.mox.MoxOrb;

import java.util.Objects;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;
import static druidsurv.util.Wiz.p;

public class MagePupil extends AbstractEasyCard {
    public final static String ID = makeID("MagePupil");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public MagePupil() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.SELF_AND_ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "MonkeyApprentice_CardArt");
        baseDamage = 3;
        baseBlock = 2;
        this.setCardBack(cardSubType.MONKEY);
        //tags.add(CardTags.STARTER_DEFEND);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.LIGHTNING));
        blck();
        this.exhaust = hasMox();
    }


    public boolean hasMox() {
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).GreenAmount > 0)
                {
                    return true;
                }
                if (((MoxOrb)p().orbs.get(i)).RubyAmount > 0)
                {
                    return true;
                }
                if (((MoxOrb)p().orbs.get(i)).BlueAmount > 0)
                {
                    return true;
                }
                if (((MoxOrb)p().orbs.get(i)).VoidAmount > 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static int countMox() {
        int count = 0;
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).GreenAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).GreenAmount;
                }
                if (((MoxOrb)p().orbs.get(i)).RubyAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).RubyAmount;
                }
                if (((MoxOrb)p().orbs.get(i)).BlueAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).BlueAmount;
                }
                if (((MoxOrb)p().orbs.get(i)).VoidAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).VoidAmount;
                }
                if (((MoxOrb)p().orbs.get(i)).RandAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).RandAmount;
                }
                if (((MoxOrb)p().orbs.get(i)).RainAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).RainAmount;
                }
            }
        }
        return count;
    }
    @Override
    public void upp() {
        upgradeBlock(3);
    }
}